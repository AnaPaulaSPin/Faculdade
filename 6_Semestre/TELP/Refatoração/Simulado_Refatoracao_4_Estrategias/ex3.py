# ============================================= Sem Refatoração =====================================================
# Uma loja utiliza um sistema para controlar seu estoque. Os produtos são cadastrados, têm suas quantidades atualizadas conforme as vendas e reposições 
# e podem ser consultados para verificar sua disponibilidade.
# O sistema também permite gerar informações sobre os produtos para exibição no catálogo.
def register_product(products, product_id, name, price, quantity):
    products[product_id] = {
        "id": product_id,
        "name": name,
        "price": price,
        "quantity": quantity,
        "active": True
    }


def sell_product(products, product_id, quantity_sold):
    product = products.get(product_id)

    if product is None:
        raise ValueError("Product not found")

    if not product["active"]:
        raise ValueError("Product is inactive")

    if product["quantity"] < quantity_sold:
        raise ValueError("Insufficient stock")

    product["quantity"] -= quantity_sold

    return product["quantity"]


def restock_product(products, product_id, quantity_added):
    product = products.get(product_id)

    if product is None:
        raise ValueError("Product not found")

    product["quantity"] += quantity_added

    return product["quantity"]


def update_product_price(products, product_id, new_price):
    product = products.get(product_id)

    if product is None:
        raise ValueError("Product not found")

    if new_price <= 0:
        raise ValueError("Invalid price")

    product["price"] = new_price


def get_product_information(products, product_id):
    product = products.get(product_id)

    if product is None:
        return None

    return {
        "name": product["name"],
        "price": product["price"],
        "available": product["quantity"] > 0,
        "quantity": product["quantity"]
    }


def deactivate_product(products, product_id):
    product = products.get(product_id)

    if product is None:
        raise ValueError("Product not found")

    product["active"] = False


def generate_inventory_report(products):
    report = []

    for product in products.values():
        report.append({
            "id": product["id"],
            "name": product["name"],
            "quantity": product["quantity"],
            "total_value": product["price"] * product["quantity"],
            "active": product["active"]
        })

    return report
# ============================================= Com Refatoração =====================================================

# Explicação = 