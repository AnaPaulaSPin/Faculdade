# ======================================= Sem refatoracao =======================================
class Product:
    def __init__(self, name, price, weight, stock):
        self.name = name
        self.price = price
        self.weight = weight
        self.stock = stock


def calculate_shipping(product, distance):
    if product.weight <= 1:
        weight_fee = 5
    elif product.weight <= 5:
        weight_fee = 12
    else:
        weight_fee = 20

    distance_fee = distance * 0.30

    return weight_fee + distance_fee


class Checkout:
    def __init__(self, product, distance):
        self.product = product
        self.distance = distance

    def finalize_purchase(self):
        shipping_cost = calculate_shipping(
            self.product,
            self.distance
        )

        total = self.product.price + shipping_cost

        self.product.update_stock(1)

        print("Product:", self.product.name)
        print("Shipping:", shipping_cost)
        print("Total:", total)

        return total

# ====================== Com Refatoração =======================================
# mantem tbm T_T


    