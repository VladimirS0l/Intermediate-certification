import controller

def start_menu():
    print("Добро пожаловать в приложение заметки")
    choice = None
    while choice != "q":
        print(("МЕНЮ\n1 - Показать все заметки\n"
               + "2 - Найти заметку/ки\n"
               + "3 - Добавить заметку\n"
               + "4 - Изменить заметку\n"
               + "5 - Удалить заметку\n"
               + "6 - Сохранить заметки в формате csv\n"
               + "7 - Загрузить заметки из формата csv\n"
               + "q - Выход"))
        choice = input("Введите Ваш выбор: ")
        if choice == "1":
            controller.show_notes()
        elif choice == "2":
            controller.search_note()
        elif choice == "3":
            controller.add_note()
        elif choice == "4":
            controller.change_note()
        elif choice == "5":
            controller.delete_note()
        elif choice == "6":
            controller.save_notepad()
        elif choice == "7":
            controller.load_notepad()
        elif choice == "q":
            print("Bye")
        else:
            print("Неверный ввод попробуй еще раз!")
            choice = input("Введите Ваш выбор: ")
