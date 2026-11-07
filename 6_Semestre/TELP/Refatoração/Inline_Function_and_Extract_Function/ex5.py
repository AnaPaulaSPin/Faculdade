# Sem refatoracao
def calculate_salary(employee):
    base_salary = employee["salary"]
    bonus = base_salary * 0.10
    deductions = base_salary * 0.05
    final_salary = base_salary + bonus - deductions

    return final_salary


# Com Refatoração
def calculate_salary(employee):
    base_salary = employee["salary"]
    bonus = base_salary * 0.10
    deductions = base_salary * 0.05

    return base_salary + bonus - deductions
