# Sem refatoracao
def generate_library_report(books):
    available_books = []
    borrowed_books = []

    for book in books:
        if book["available"]:
            available_books.append(book)
        else:
            borrowed_books.append(book)

    print("LIBRARY REPORT")
    print("----------------------")
    print("Total books:", len(books))
    print("Available books:", len(available_books))
    print("Borrowed books:", len(borrowed_books))

    print("\nAvailable titles:")

    for book in available_books:
        print("-", book["title"], "|", book["author"])

    return len(available_books), len(borrowed_books)
  


# Com Refatoração - externalizar função
def generate_library_report(books):
    available_books = []
    borrowed_books = []

    for book in books:
        if book["available"]:
            available_books.append(book)
        else:
            borrowed_books.append(book)

    print_details(books, available_books, borrowed_books)

    return len(available_books), len(borrowed_books)


def print_details(books,available_books,borrowed_books):
    print("LIBRARY REPORT")
    print("----------------------")
    print("Total books:", len(books))
    print("Available books:", len(available_books))
    print("Borrowed books:", len(borrowed_books))

    print("\nAvailable titles:")

    for book in available_books:
        print("-", book["title"], "|", book["author"])
