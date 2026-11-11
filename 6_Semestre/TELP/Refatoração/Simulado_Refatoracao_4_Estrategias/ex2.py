# ============================================= Sem Refatoração =====================================================

def calculate_order_total(customer, products, shipping_address,
                          shipping_method, discount_code,
                          payment_method):

    subtotal = 0

    for product in products:
        subtotal += product["price"] * product["quantity"]

    discount = 0

    if discount_code == "WELCOME10":
        discount = subtotal * 0.10
    elif discount_code == "VIP20" and customer["category"] == "VIP":
        discount = subtotal * 0.20

    shipping_cost = calculate_shipping(
        products,
        shipping_address,
        shipping_method
    )

    return subtotal - discount + shipping_cost


def calculate_shipping(products, shipping_address, shipping_method):
    total_weight = 0

    for product in products:
        total_weight += product["weight"] * product["quantity"]

    if shipping_method == "express":
        return total_weight * 2.5

    if shipping_address["state"] == "BA":
        return total_weight * 1.2

    return total_weight * 1.8


def prepare_payment(customer, products, shipping_address,
                    shipping_method, discount_code,
                    payment_method):

    total = calculate_order_total(
        customer,
        products,
        shipping_address,
        shipping_method,
        discount_code,
        payment_method
    )

    return {
        "customer_id": customer["id"],
        "amount": total,
        "payment_method": payment_method,
        "status": "pending"
    }


def generate_order_summary(customer, products, shipping_address,
                           shipping_method, discount_code,
                           payment_method):

    total = calculate_order_total(
        customer,
        products,
        shipping_address,
        shipping_method,
        discount_code,
        payment_method
    )

    return {
        "customer": customer["name"],
        "products_count": len(products),
        "destination": shipping_address["city"],
        "shipping": shipping_method,
        "payment": payment_method,
        "discount": discount_code,
        "total": total
    }
    
# ============================================= Com Refatoração =====================================================

# Explicação = Aplicaria a estratégia de Introduzi objeto na variável pois as variáveis customer, products, shipping_address, shipping_method, discount_code, payment_method são utilizadas diversas vezes no código de maneira repetitiva oq poderia ser evitado so passando o parâmetro de um objeto.

class Order:
    def __init__(self, customer, products, shipping_address,
                 shipping_method, discount_code, payment_method):
        self.customer = customer
        self.products = products
        self.shipping_address = shipping_address
        self.shipping_method = shipping_method
        self.discount_code = discount_code
        self.payment_method = payment_method


def calculate_order_total(order):
    subtotal = 0

    for product in order.products:
        subtotal += product["price"] * product["quantity"]

    discount = 0

    if order.discount_code == "WELCOME10":
        discount = subtotal * 0.10
    elif order.discount_code == "VIP20" and order.customer["category"] == "VIP":
        discount = subtotal * 0.20

    shipping_cost = calculate_shipping(order)

    return subtotal - discount + shipping_cost


def calculate_shipping(order):
    total_weight = 0

    for product in order.products:
        total_weight += product["weight"] * product["quantity"]

    if order.shipping_method == "express":
        return total_weight * 2.5

    if order.shipping_address["state"] == "BA":
        return total_weight * 1.2

    return total_weight * 1.8


def prepare_payment(order):
    total = calculate_order_total(order)

    return {
        "customer_id": order.customer["id"],
        "amount": total,
        "payment_method": order.payment_method,
        "status": "pending"
    }


def generate_order_summary(order):
    total = calculate_order_total(order)

    return {
        "customer": order.customer["name"],
        "products_count": len(order.products),
        "destination": order.shipping_address["city"],
        "shipping": order.shipping_method,
        "payment": order.payment_method,
        "discount": order.discount_code,
        "total": total
    }