# ============================================= Sem Refatoração =====================================================

commission_rate = 0.08


def calculate_commission(sales_amount):
    return sales_amount * commission_rate


def calculate_seller_payment(base_salary, sales_amount):
    commission = sales_amount * commission_rate
    return base_salary + commission


def update_commission_rate(new_rate):
    global commission_rate

    if new_rate < 0 or new_rate > 0.30:
        raise ValueError("Invalid commission rate")

    commission_rate = new_rate


def generate_sales_report(sellers):
    report = []

    for seller in sellers:
        commission = seller["sales_amount"] * commission_rate

        report.append({
            "seller": seller["name"],
            "sales": seller["sales_amount"],
            "commission": commission
        })

    return report


def calculate_total_commissions(sellers):
    total = 0

    for seller in sellers:
        total += seller["sales_amount"] * commission_rate

    return total


# ============================================= Com Refatoração =====================================================

# Explicação = Eu usaria duas estratégias para essa questão, a primeira é o encapsulamento da variável comission_rate que esta sendo utilizada em varias parte do código e é uma regra de negocio. Como também usaria Combinar funções em uma classe principalmente porque as funções calculate_commission() calculate_seller_payment() generate_sales_report() 
# utiliza a variável sales_amount:

commission_rate = 0.08

def get_commission_rate():
   return comission_rate

def update_commission_rate(new_rate):
    global commission_rate

    if new_rate < 0 or new_rate > 0.30:
        raise ValueError("Invalid commission rate")

    commission_rate = new_rate


class Sales:
    def __init__(self, sales_amount):
        self.sales_amount = sales_amount

def calculate_commission(self):
    return self.sales_amount * get_commission_rate()

def calculate_seller_payment(self, base_salary):
    commission = self.sales_amount * get_commission_rate()
    return base_salary + commission


def generate_sales_report(sellers):
    report = []

    for seller in sellers:
        commission = seller["sales_amount"] * get_commission_rate()

        report.append({
            "seller": seller["name"],
            "sales": seller["sales_amount"],
            "commission": commission
        })

    return report


def calculate_total_commissions(sellers):
    total = 0

    for seller in sellers:
        total += seller["sales_amount"] * get_commission_rate()

    return total
