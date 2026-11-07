# sem refatorardef register_user(user):
def register_user(user):
    print("Validating user information...")

    if not user["name"]:
        print("Invalid name")
        return False

    if not user["email"]:
        print("Invalid email")
        return False

    print("Saving user...")
    print("Sending confirmation email...")

    return True

# refatorado
def register_user(user):
    print("Validating user information...")

    if not validate_user(user):
        return False

    print("Saving user...")
    print("Sending confirmation email...")

    return True


def validate_user(user):
    if not user["name"]:
        print("Invalid name")
        return False

    if not user["email"]:
        print("Invalid email")
        return False

    return True