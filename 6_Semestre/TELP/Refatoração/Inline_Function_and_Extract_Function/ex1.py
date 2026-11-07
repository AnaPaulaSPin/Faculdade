# Sem refatoracao
def get_employee_status(employee):
    return "Senior" if is_experienced(employee) else "Junior"

def is_experienced(employee):
    return employee["years_of_experience"] >= 5


# Com Refatoração
def get_employee_status(employee):
  return "Senior" if employee["years_of_experience"] >= 5 else "Junior"


# No meu entendimento isso é igual:
def get_employee_status(employee):
   if employee["years_of_experience"] >= 5:
     return "Senior" 
   else:
     return "Junior"
