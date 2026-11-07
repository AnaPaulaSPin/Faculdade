# Sem refatoracao
def calculate_employee_payment(employee):
    hours_worked = employee["hours_worked"]
    hourly_rate = employee["hourly_rate"]

    regular_hours = min(hours_worked, 40)
    overtime_hours = max(hours_worked - 40, 0)

    regular_payment = regular_hours * hourly_rate
    overtime_payment = overtime_hours * hourly_rate * 1.5

    gross_payment = regular_payment + overtime_payment

    tax = gross_payment * 0.10
    net_payment = gross_payment - tax

    print("PAYMENT SUMMARY")
    print("----------------------")
    print("Employee:", employee["name"])
    print("Regular payment:", regular_payment)
    print("Overtime payment:", overtime_payment)
    print("Gross payment:", gross_payment)
    print("Tax:", tax)
    print("Net payment:", net_payment)

    return net_payment


# Com Refatoração - externalizar função

def calculate_employee_payment(employee):
    hours_worked = employee["hours_worked"]
    hourly_rate = employee["hourly_rate"]

    regular_hours = min(hours_worked, 40)
    overtime_hours = max(hours_worked - 40, 0)

    regular_payment = regular_hours * hourly_rate
    overtime_payment = overtime_hours * hourly_rate * 1.5

    gross_payment = regular_payment + overtime_payment

    tax = gross_payment * 0.10
    net_payment = gross_payment - tax

    print_Pagymet(employee["name"], regular_payment, overtime_payment, gross_payment, tax, net_payment)

    return net_payment


def print_Pagymet(name, regular_payment, overtime_payment, gross_payment, tax, net_payment):
    print("PAYMENT SUMMARY")
    print("----------------------")
    print("Employee:", name)
    print("Regular payment:", regular_payment)
    print("Overtime payment:", overtime_payment)
    print("Gross payment:", gross_payment)
    print("Tax:", tax)
    print("Net payment:", net_payment)
