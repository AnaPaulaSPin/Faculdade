# Sem refatoracao
def get_shipping_cost(order):
    return calculate_delivery_fee(order)

def calculate_delivery_fee(order):
    return 25 if order["weight"] > 10 else 10


# Com Refatoração
def get_shipping_cost(order):
    return 25 if order["weight"] > 10 else 10
    


