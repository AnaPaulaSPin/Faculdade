# ============================================= Sem Refatoração =====================================================
# Uma empresa possui um sistema interno para acompanhar o desempenho dos funcionários. O sistema calcula indicadores individuais, 
# identifica funcionários que atingiram suas metas e prepara informações para os relatórios gerenciais.
# A equipe percebeu que as operações relacionadas à avaliação dos funcionários estão distribuídas em diferentes 
# partes do projeto.
class Employee:
    def __init__(self, employee_id, name, department,
                 base_salary, sales_target, actual_sales):
        self.employee_id = employee_id
        self.name = name
        self.department = department
        self.base_salary = base_salary
        self.sales_target = sales_target
        self.actual_sales = actual_sales


def calculate_sales_performance(employee):
    if employee.sales_target == 0:
        return 0

    return (employee.actual_sales / employee.sales_target) * 100


def calculate_performance_bonus(employee):
    performance = calculate_sales_performance(employee)

    if performance >= 120:
        return employee.base_salary * 0.20

    if performance >= 100:
        return employee.base_salary * 0.10

    return 0


def calculate_final_salary(employee):
    bonus = calculate_performance_bonus(employee)

    return employee.base_salary + bonus


def generate_employee_report(employee):
    performance = calculate_sales_performance(employee)
    bonus = calculate_performance_bonus(employee)
    final_salary = calculate_final_salary(employee)

    return {
        "employee_id": employee.employee_id,
        "name": employee.name,
        "department": employee.department,
        "performance": performance,
        "bonus": bonus,
        "final_salary": final_salary
    }


def get_department_performance(employees, department):
    department_employees = [
        employee for employee in employees
        if employee.department == department
    ]

    total_performance = 0

    for employee in department_employees:
        total_performance += calculate_sales_performance(employee)

    if not department_employees:
        return 0

    return total_performance / len(department_employees)
# ============================================= Com Refatoração =====================================================

# Explicação = 