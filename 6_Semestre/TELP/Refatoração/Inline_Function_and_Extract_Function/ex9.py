# Sem refatoracao
def update_inventory(product, quantity_sold):
    current_stock = product["stock"]

    if quantity_sold > current_stock:
        print("Insufficient stock")
        return False

    product["stock"] = current_stock - quantity_sold

    if product["stock"] == 0:
        product["status"] = "Out of stock"
    elif product["stock"] <= 5:
        product["status"] = "Low stock"
    else:
        product["status"] = "Available"

    print("Inventory updated")
    print("Product:", product["name"])
    print("Remaining stock:", product["stock"])
    print("Status:", product["status"])

    return True


# Com Refatoração - externalizar função
def update_inventory(product, quantity_sold):
    current_stock = product["stock"]

    if quantity_sold > current_stock:
        print("Insufficient stock")
        return False

    product["stock"] = current_stock - quantity_sold
    product["status"] = update_status(product["stock"])

    print_uptade(product)

    return True

def update_status(stock):
    if stock == 0:
        return "Out of stock"
    elif stock <= 5:
        return "Low stock"
    else:
        return "Available"

def print_uptade(product):
    print("Inventory updated")
    print("Product:", product["name"])
    print("Remaining stock:", product["stock"])
    print("Status:", product["status"])