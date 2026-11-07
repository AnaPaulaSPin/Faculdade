# Sem refatoracao
def calculate_invoice(invoice):
    total = invoice["quantity"] * invoice["unit_price"]
    tax = total * 0.15
    final_amount = total + tax

    print("Invoice total:", total)
    print("Tax:", tax)
    print("Final amount:", final_amount)

    return final_amount


# Com Refatoração
def calculate_invoice(invoice):
    total = invoice["quantity"] * invoice["unit_price"]
    tax = total * 0.15
    final_amount = total + tax

    print_details_invoice_total(total, tax, final_amount)

    return final_amount

def print_details_invoice_total(total, tax, final_amount):
   print("Invoice total:", total)
   print("Tax:", tax)
   print("Final amount:", final_amount)




