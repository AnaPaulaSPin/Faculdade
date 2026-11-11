# ============================================= Sem Refatoração =====================================================


def classify_ticket(ticket):
    if (
        ticket["severity"] == "Critical"
        and ticket["affected_users"] >= 50
        and ticket["system_status"] == "Unavailable"
        and ticket["created_hour"] >= 18
    ):
        priority = "Emergency"
    elif ticket["severity"] == "High" and ticket["affected_users"] >= 10:
        priority = "High"
    else:
        priority = "Normal"

    print("Ticket:", ticket["id"])
    print("Priority:", priority)

    return priority


# ============================================= Com Refatoração =====================================================

# Explicação = O problema desse código é a falta de clareza das regras de negócios pois estão centradas dentro do if, uma das opções para melhorar a clareza seria a extração de variável e aplico extração de função para separar as responsabilidades da função. Mas no elif não vi a necessidade de fazer isso já que é pequeno e é intendivel 

def classify_ticket(ticket):
    is_ticket_critical = ticket["severity"] == "Critical"
    exceeds_affected_users = ticket["affected_users"] >= 50
    is_ticket_Unavailable = ticket["system_status"] == "Unavailable"
    above_hour = ticket["created_hour"] >= 18
    

    if (is_ticket_critical and exceeds_affected_users and is_ticket_Unavailable and above_hour):
        priority = "Emergency"

    elif ticket["severity"] == "High" and ticket["affected_users"] >= 10:
        priority = "High"
    else:
        priority = "Normal"

    print_ticket_priority (ticket["id"], priority)

    return priority

def print_ticket_priority (ticket_id, priority):
    print("Ticket:", ticket_id)
    print("Priority:", priority)

