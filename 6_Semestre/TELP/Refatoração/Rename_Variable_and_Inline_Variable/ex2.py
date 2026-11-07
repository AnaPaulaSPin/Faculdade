
# Sem Refatoração
def calculate_employee_salary(employee):
    a = employee.base_salary
    b = employee.hours_worked
    c = a / 160

    return c * b


# Com Refatoração
def calculate_employee_salary(employee):
    base_salary = employee.base_salary
    hours_worked = employee.hours_worked
    porcetagem = base_salary  / 160 # hourly_rate -> o 160 representa as horas trabalhadas em um mês

    return porcetagem * hours_worked