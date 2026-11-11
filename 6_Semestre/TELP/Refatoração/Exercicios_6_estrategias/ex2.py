# ============================================= Sem Refatoração =====================================================

def process_payment(order):
    subtotal = order["quantity"] * order["unit_price"]
    service_fee = subtotal * 0.08

    payment_amount = subtotal + service_fee

    print("Processing payment...")
    print("Amount:", payment_amount)

    return payment_amount



# ============================================= Com Refatoração =====================================================

# Explicação = Não vejo muito oq refatorar, o código aparenta uma boa clareza a única coisa que precisa ser refatorado é a impressão, dessa forma utilizaria a estratégia de  externalizar função para separar impressão da logica do negocio. 

def process_payment(order):
    subtotal = order["quantity"] * order["unit_price"]
    service_fee = subtotal * 0.08

    payment_amount = subtotal + service_fee

    print_detailes(payment_amount)

    return payment_amount

def print_detailes(payment_amount):
    print("Processing payment...")
    print("Amount:", payment_amount)