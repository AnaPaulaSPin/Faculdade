# ============================================= Sem Refatoração =====================================================
# Um sistema de hospedagem permite cadastrar reservas, calcular valores, aplicar descontos, 
# controlar cancelamentos e gerar informações financeiras.
# O sistema atende diferentes categorias de clientes e
# possui regras comerciais que podem ser alteradas conforme as políticas da empresa

cancellation_fee = 0.15


def calculate_discount(customer_category, total_amount):
    if customer_category == "Premium":
        return total_amount * 0.15

    if customer_category == "Gold":
        return total_amount * 0.10

    return 0


def calculate_reservation_amount(customer_category, daily_rate,
                                 number_of_days, extra_services):

    accommodation_total = daily_rate * number_of_days

    services_total = sum(
        service["price"] for service in extra_services
    )

    subtotal = accommodation_total + services_total

    discount = calculate_discount(customer_category, subtotal)

    return subtotal - discount


def calculate_cancellation_amount(customer_category, daily_rate,
                                  number_of_days, extra_services):

    total = calculate_reservation_amount(
        customer_category,
        daily_rate,
        number_of_days,
        extra_services
    )

    return total * cancellation_fee


def generate_reservation_invoice(customer_category, daily_rate,
                                 number_of_days, extra_services,
                                 guest_name, room_number):

    accommodation_total = daily_rate * number_of_days

    services_total = sum(
        service["price"] for service in extra_services
    )

    subtotal = accommodation_total + services_total

    discount = calculate_discount(customer_category, subtotal)

    final_amount = subtotal - discount

    return {
        "guest": guest_name,
        "room": room_number,
        "days": number_of_days,
        "accommodation": accommodation_total,
        "services": services_total,
        "discount": discount,
        "total": final_amount
    }


def update_cancellation_fee(new_fee):
    global cancellation_fee

    if new_fee < 0 or new_fee > 1:
        raise ValueError("Invalid cancellation fee")

    cancellation_fee = new_fee


def generate_monthly_revenue(reservations):
    total_revenue = 0

    for reservation in reservations:
        total_revenue += calculate_reservation_amount(
            reservation["customer_category"],
            reservation["daily_rate"],
            reservation["number_of_days"],
            reservation["extra_services"]
        )

    return total_revenue


def generate_customer_reservation_report(reservations):
    report = []

    for reservation in reservations:
        amount = calculate_reservation_amount(
            reservation["customer_category"],
            reservation["daily_rate"],
            reservation["number_of_days"],
            reservation["extra_services"]
        )

        report.append({
            "guest": reservation["guest_name"],
            "room": reservation["room_number"],
            "amount": amount
        })

    return report
# ============================================= Com Refatoração =====================================================

# Explicação = 