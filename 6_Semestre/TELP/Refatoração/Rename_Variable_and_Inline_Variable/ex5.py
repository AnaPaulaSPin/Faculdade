# Sem refatoracao
def process_order(order):
    a = order.quantity
    b = order.unit_price

    subtotal = a * b
    discount = subtotal * 0.15

    final_price = subtotal - discount

    print("Subtotal:", subtotal)
    print("Desconto:", discount)

    result = final_price > 500

    return result


# Com Refatoração

def process_order(order):

    subtotal = order.quantity * order.unit_price

    discount = subtotal * 0.15

    print("Subtotal:", subtotal)
    print("Desconto:", discount)

    return (subtotal - discount) > 500