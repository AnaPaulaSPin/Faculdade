# ============================================= Sem Refatoração =====================================================

def start_task(task, user):
    x = task["status"]
    y = user["active"]
    z = task["assigned_to"]

    if x == "Pending" and y and z == user["username"]:
        result = True
    else:
        result = False

    print("Task:", task["title"])
    print("Can start:", result)

    return result




# ============================================= Com Refatoração =====================================================

# Explicação = Usaria renomeação de variável para as variáveis x,y e z que não ficam claro oq representam ao longo do código por ser apenas letras. Aplicaria extração de função para mover a parte do print, já que uma boa pratica é separar calculo/logica da parte de impressão.

def start_task(task, user):
    task_status = task["status"]
    is_user_active = user["active"]
    assigned_username = task["assigned_to"]

    if task_status == "Pending" and  is_user_active and assigned_username == user["username"]:
        result = True
    else:
        result = False

    print_task (task,result)

    return result

def print_task (task,result):
   print("Task:", task["title"])
   print("Can start:", result)