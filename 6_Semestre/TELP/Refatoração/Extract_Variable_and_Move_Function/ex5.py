# =========================== Sem Refatoração ===========================
# sales.py:
def calculate_average_sales(sales):
    total = sum(sales)
    return total / len(sales)


def calculate_high_sales(sales):
    return [sale for sale in sales if sale > 1000]

# sales_report.py:
from sales import calculate_average_sales, calculate_high_sales


def generate_sales_report(sales):
    average = calculate_average_sales(sales)
    high_sales = calculate_high_sales(sales)

    print("Average sales:", average)
    print("High sales:", len(high_sales))

    return {
        "average": average,
        "high_sales": high_sales
    }



# =========================== Com Refatoração - Não houve necessidade ===========================