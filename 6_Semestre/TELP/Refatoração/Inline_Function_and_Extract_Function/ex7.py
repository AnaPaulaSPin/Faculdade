# Sem refatoracao
def authenticate_user(user, password):
    if user is None:
        return False

    if user["status"] != "active":
        return False

    if not check_password(password, user["password"]):
        return False

    return True

def check_password(input_password, stored_password):
    return input_password == stored_password
  


# Com Refatoração - internalizar função
def authenticate_user(user, password):
    if user is None:
        return False

    if user["status"] != "active":
        return False

    if password != user["password"]:
        return False

    return True