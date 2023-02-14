
def ask_name(question, low, high):
    id = None
    while id not in range(low, high):
        responce = input(question)
        id = len(responce)
    return responce

def ask_number(question, low, high):
    responce = None
    while responce not in range(low, high):
        try:
            responce = int(input(question))
            if responce in range(low, high):
                return responce
            else:
                print("Неверный ввод")
                responce = int(input(question))
        except:
            print("Неверный ввод")
