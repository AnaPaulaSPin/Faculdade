# Sem refatoracao

def process_order(order):
    customer = order["customer"]
    items = order["items"]
    subtotal = 0
    
    for item in items:
        subtotal += item["quantity"] * item["unit_price"]

    if customer["category"] == "Premium":
        discount = subtotal * 0.15
    elif customer["category"] == "Regular":
        discount = subtotal * 0.05
    else:
        discount = 0

    total = subtotal - discount

    print("Order processed successfully")
    print("Customer:", customer["name"])
    print("Items:", len(items))
    print("Subtotal:", subtotal)
    print("Discount:", discount)
    print("Total:", total)

    return total  

# Com Refatoração - externalizar função
def process_order(order):
    customer = order["customer"]
    items = order["items"]

    subtotal = 0

    for item in items:
        subtotal += item["quantity"] * item["unit_price"]

    discount = tipo_discontos(customer, subtotal)

    total = subtotal - discount

    print_detalhes(customer["name"],items,subtotal,discount,total)

    return total


  
def tipo_discontos(customer, subtotal):
    if customer["category"] == "Premium":
        return subtotal * 0.15
    elif customer["category"] == "Regular":
        return subtotal * 0.05
    return 0

def print_detalhes(nome,items,subtotal,discount,total):
    print("Order processed successfully")
    print("Customer:", nome)
    print("Items:", len(items))
    print("Subtotal:", subtotal)
    print("Discount:", discount)
    print("Total:", total)
  






