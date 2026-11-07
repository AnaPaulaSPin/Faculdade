# =========================== Sem Refatoração ===========================
# document.py
class Document:
    def __init__(self, title, content, author):
        self.title = title
        self.content = content
        self.author = author

# document_export.py:
def generate_filename(document):
    filename = document.title.lower().replace(" ", "_")
    author = document.author.lower().replace(" ", "_")

    return f"{filename}_{author}.txt"

# export_service.py:
from document_export import generate_filename


def export_document(document):
    filename = generate_filename(document)

    with open(filename, "w", encoding="utf-8") as file:
        file.write(document.content)

    print("Document exported:", filename)

    return filename



# =========================== Com Refatoração - Mover Função ===========================
# document.py
class Document:
    def __init__(self, title, content, author):
        self.title = title
        self.content = content
        self.author = author

    def generate_filename(self):
      filename = self.title.lower().replace(" ", "_")
      author = self.author.lower().replace(" ", "_")

      return f"{filename}_{author}.txt"

# export_service.py:
def export_document(document):
    filename = document.generate_filename()

    with open(filename, "w", encoding="utf-8") as file:
        file.write(document.content)

    print("Document exported:", filename)

    return filename