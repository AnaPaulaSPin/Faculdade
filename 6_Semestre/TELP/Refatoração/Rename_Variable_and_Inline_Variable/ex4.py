# Sem refatoracao
def check_customer(customer): 
    x = customer.years_as_customer 
    y = customer.total_purchases 
 
    z = x >= 3 
    w = y >= 1000 
 
    result = z and w 
 
    return result


# Com Refatoração
def check_customer(customer): 
    years_as_customer = customer.years_as_customer 
    total_purchases = customer.total_purchases 
 
    tempo_ano_valido = years_as_customer >= 3 # has_minimum_time
    total_compras_validas =  total_purchases >= 1000 #  has_minimum_purchases
 
    result = tempo_ano_valido and total_compras_validas # is_eligible
 
    return result