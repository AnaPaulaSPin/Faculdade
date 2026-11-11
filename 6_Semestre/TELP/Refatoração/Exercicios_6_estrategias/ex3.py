# ============================================= Sem Refatoração =====================================================

def issue_certificate(student):
    if student is None:
        return False

    if student["completed_lessons"] < student["total_lessons"]:
        return False

    if student["final_grade"] < 7:
        return False

    if student["payment_status"] != "Paid":
        return False

    print("Certificate issued:", student["name"])
    return True


def has_completed_course(student):
    return (
        student["completed_lessons"] >= student["total_lessons"]
        and student["final_grade"] >= 7
        and student["payment_status"] == "Paid"
    )


# ============================================= Com Refatoração =====================================================

# Explicação: as duas funções fazem a mesma coisa de formas diferentes, dessa forma usamos a função has_completed_course(student) em issue_certificate(student), dessa forma uma extração de função e separação de responsabilidades assim (esqueci o nome da tecnica), mas dessa forma o codigo separa a função para que issue_certificate(student) retorne se o aluno esta valido pro certificado ou nao. Enquanto has_completed_course(student) valida as condições 

def issue_certificate(student):
    if student is None:
        return False

    if not has_completed_course(student):
        return False

    print("Certificate issued:", student["name"])
    return True


def has_completed_course(student):
    return (
        student["completed_lessons"] >= student["total_lessons"]
        and student["final_grade"] >= 7
        and student["payment_status"] == "Paid"
    )