# ============================================= Sem Refatoração =====================================================

def calculate_reservation(reservation):
    room_price = reservation["daily_rate"] * reservation["days"]

    discount = calculate_discount(reservation, room_price)

    total = room_price - discount

    print("Guest:", reservation["guest"])
    print("Room:", reservation["room_type"])
    print("Original price:", room_price)
    print("Discount:", discount)
    print("Final price:", total)

    return total


def calculate_discount(reservation, room_price):
    if reservation["guest_type"] == "Member":
        return room_price * 0.10

    return 0




# ============================================= Com Refatoração====================================================

# Explicação = Usaria extração de função para separar responsabilidades do calculo e retorno da reserva e a parte de impressão, logo criaria uma função print_details_reservation(reservation, room_price, discount, total)

def calculate_reservation(reservation):
    room_price = reservation["daily_rate"] * reservation["days"]

    discount = calculate_discount(reservation, room_price)

    total = room_price - discount

    print_details_reservation(reservation, room_price, discount, total)

    return total


def calculate_discount(reservation, room_price):
    if reservation["guest_type"] == "Member":
        return room_price * 0.10

    return 0

def print_details_reservation(reservation, room_price, discount, total):
    print("Guest:", reservation["guest"])
    print("Room:", reservation["room_type"])
    print("Original price:", room_price)
    print("Discount:", discount)
    print("Final price:", total)

