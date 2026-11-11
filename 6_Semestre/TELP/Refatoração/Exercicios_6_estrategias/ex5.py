# ============================================= Sem Refatoração =====================================================
# image.py:
class Image:
    def __init__(self, filename, width, height, format):
        self.filename = filename
        self.width = width
        self.height = height
        self.format = format

    def resize(self, new_width, new_height):
        self.width = new_width
        self.height = new_height

# image_processing.py:
def calculate_aspect_ratio(image):
    return image.width / image.height


def calculate_file_name(image):
    return image.filename.lower().replace(" ", "_")

# gallery.py:

from image_processing import calculate_aspect_ratio, calculate_file_name


class Gallery:
    def __init__(self):
        self.images = []

    def add_image(self, image):
        self.images.append(image)

    def display_image_information(self, image):
        ratio = calculate_aspect_ratio(image)
        filename = calculate_file_name(image)

        print("Filename:", filename)
        print("Dimensions:", image.width, "x", image.height)
        print("Aspect ratio:", ratio)


# ============================================= Com Refatoração =====================================================

# Explicação = As funções calculate_file_name(image) e calculate_aspect_ratio(image) estão relacionadas totalmente a classe de Imagem, dessa forma usamos a estratégia de Mover Função para mover essas funções para Image:
# image.py:
class Image:
    def __init__(self, filename, width, height, format):
        self.filename = filename
        self.width = width
        self.height = height
        self.format = format

    def resize(self, new_width, new_height):
        self.width = new_width
        self.height = new_height

    def calculate_aspect_ratio(self):
        return self.width / self.height

    def calculate_file_name(self):
        return self.filename.lower().replace(" ", "_")

# gallery.py:

class Gallery:
    def __init__(self):
        self.images = []

    def add_image(self, image):
        self.images.append(image)

    def display_image_information(self, image):
        ratio = image.calculate_aspect_ratio()
        filename = image.calculate_file_name()

        print("Filename:", filename)
        print("Dimensions:", image.width, "x", image.height)
        print("Aspect ratio:", ratio)


