
# refatore esse codigo
def calculate_product(product):
    x = product.price
    y = x * 2

    return y

# refatorado
def calculate_product(product):
    return product.price * 2
