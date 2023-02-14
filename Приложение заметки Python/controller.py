import model
import ui
import import_export_csv as imp_exp

def start():
    ui.start_menu()

def search_note():
    model.search_notes()

def show_notes():
    model.show_all_notes()

def add_note():
    model.add_new_note()

def change_note():
    model.change_one_note()

def delete_note():
    model.delete_one_note()

def save_notepad():
    imp_exp.export_notepad_in_csv()

def load_notepad():
    imp_exp.import_notepad_in_csv()