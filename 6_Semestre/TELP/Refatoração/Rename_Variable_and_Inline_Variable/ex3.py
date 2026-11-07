# Sem refatoracao
def calculate_total(order): 
   item_price = order.price
   quantity = order.quantity  
 
   subtotal = item_price * quantity
   tax = subtotal * 0.10 
   total = subtotal + tax 
 
   return total

# Com Refatoração
def calculate_total(order): 
    subtotal = order.price * order.quantity 
    return subtotal + (subtotal * 0.10) 