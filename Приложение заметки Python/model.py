import datetime
import json
import check

notepad = {}
search_note = []
id = 0

def show_all_notes():
    notes = read_write(notepad, 'r')
    if len(notes) == 0:
        print("У вас нет контактов!")
    else:
        print("Показываю Вам все заметки: ")
        for num, i in enumerate(notes):

            print(f"{num + 1}\n"
                  + f"Name: {i['Name']}\n"
                  + f"Description: {i['Description']}\n"
                  + f"Date: {i['Date']}\n")

def add_new_note():
    global notepad
    notepad["Name"] = check.ask_name("Введите название заметки(не более 20 символов): ", 0, 20)
    notepad["Description"] = input("Введите описание заметки: ")
    dt = datetime.datetime.now().strftime("%Y-%m-%d-%H.%M.%S")
    notepad["Date"] = dt
    read_write(notepad, "rw")
    print(f"Заметка добавлена")

def delete_one_note():
    global notepad
    global id
    notes = read_write(notepad, 'r')
    for num, i in enumerate(notes):
        print(f"{num + 1}\n"
              + f"Name: {i['Name']}\n"
              + f"Description: {i['Description']}\n"
              + f"Date: {i['Date']}\n")
    id = check.ask_number("Введите номер заметки, которую хотите удалить: ", 0, len(notes))
    notes.remove(notes[id - 1])
    notepad = notes
    read_write(notepad, 'w')
    print("Заметка удалена")

def change_one_note():
    global notepad
    global id
    notes = read_write(notepad, 'r')
    for num, i in enumerate(notes):
        print(f"{num + 1}\n"
              + f"Name: {i['Name']}\n"
              + f"Description: {i['Description']}\n"
              + f"Date: {i['Date']}\n")
    id = check.ask_number("Введите номер заметки, которую хотите изменить: ", 0, len(notes)+1)
    notes[id - 1]['Name'] = check.ask_name("Введите новое название заметки(не более 20 символов): ", 0, 20)
    notes[id - 1]['Description'] = input(("Введите новое описание заметки: "))
    dt = datetime.datetime.now().strftime("%Y-%m-%d-%H.%M.%S")
    notes[id - 1]['Date'] = dt
    notepad = notes
    read_write(notepad, 'w')
    print("Заметка изменена")

def read_write(notepad, arg):
    if arg == "rw":
        try:
            with open('notepad_db.json', 'r') as f:
                write_notepad = json.load(f)
        except:
            write_notepad = []
        write_notepad.append(notepad)
        with open('notepad_db.json', 'w') as file:
            json.dump(write_notepad, file, indent=2, ensure_ascii=False)
    elif arg == "r":
        try:
            with open('notepad_db.json', 'r') as f:
                write_notepad = json.load(f)
        except:
            write_notepad = []
        return write_notepad
    elif arg == 'w':
        with open('notepad_db.json', 'w') as file:
            json.dump(notepad, file, indent=2, ensure_ascii=False)

def search_notes():
    text = input("Начните вводить текст(название, описание или дату заметки): ")
    global search_note
    notes = read_write(notepad, 'r')
    for i in notes:
        if text in i['Name'] or text in i['Description'] or text in i['Date']:
            search_note.append(i)
    if len(search_note) == 0:
        print("Совпадений не найдено")
    print(f"Найдено {len(search_note)} контактов")
    for num, i in enumerate(search_note):
        print(f"{num + 1}\n"
              + f"Name: {i['Name']}\n"
              + f"Description: {i['Description']}\n"
              + f"Date: {i['Date']}\n")
