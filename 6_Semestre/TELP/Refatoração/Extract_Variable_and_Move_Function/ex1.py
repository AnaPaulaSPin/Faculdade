# Sem refatoracao
def can_watch_content(user, content):
    if (user["subscription"] == "Premium"
        and user["age"] >= content["minimum_age"]
        and content["available"]
        and user["country"] in content["available_countries"]):
        return True

    return False


# Com Refatoração - Extrair variavel 
def can_watch_content(user, content):
    has_preumium = user["subscription"] == "Premium"
    has_age = user["age"] >= content["minimum_age"]
    can_available = content["available"]
    can_available_countries = user["country"] in content["available_countries"]

    return has_preumium and has_age and can_available and can_available_countries