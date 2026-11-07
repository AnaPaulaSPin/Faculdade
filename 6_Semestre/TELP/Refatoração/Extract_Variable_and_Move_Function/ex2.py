# Sem refatoracao
def analyze_access(log):
    if (
        log["failed_attempts"] >= 5
        and log["account_status"] == "active"
        and log["ip_address"] not in log["trusted_ips"]
        and log["hour"] < 6
    ):
        print("Suspicious access detected")
        return "ALERT"

    print("Access considered normal")
    return "NORMAL"


# Com Refatoração - externalizar variável

def analyze_access(log):
   has_failed_attempts = log["failed_attempts"] >= 5
   has_account_active = log["account_status"] == "active"
   is_trusted_ips = log["ip_address"] not in log["trusted_ips"]
   has_hour = log["hour"] < 6

   if (has_failed_attempts and has_account_active and is_trusted_ips and has_hour):
        print("Suspicious access detected")
        return "ALERT"

   print("Access considered normal")
   return "NORMAL"