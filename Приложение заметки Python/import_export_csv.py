import csv
import json

import model

notepad = {}

def export_notepad_in_csv():
    notes = model.read_write(notepad, 'r')
    if len(notes) == 0:
        print("У вас нет контактов для экспорта")
        return
    count = 0
    with open("export_csv_db.csv", mode="w", encoding="utf-8") as file:
        file_writer = csv.writer(file, delimiter=",", lineterminator="\r")
        file_writer.writerow(["Name", "Description", "Date"])
        for i in notes:
            file_writer.writerow([i["Name"], i["Description"], i["Date"]])
            count += 1
    print(f"Экспорт завершен, экспортировано {count} контактов!")

def import_notepad_in_csv():
    result = []
    with open("export_csv_db.csv", mode="r", encoding='utf-8') as f:
        f = csv.reader(f, delimiter=",")
        try:
            count = 0
            for row in f:
                if count == 0:
                    count += 1
                    continue
                else:
                    temp = {}
                    temp["Name"] = row[0]
                    temp["Description"] = row[1]
                    temp["Date"] = row[2]
                    result.append(temp)
                count += 1
        except:
            print("Импорт невозможен файл не соответствует стандарту!")
    if len(result) == 0:
        print('Файл пустой для импорта')
    count -= 1
    with open("notepad_db.json", 'w') as file:
        json.dump(result, file, indent=2, ensure_ascii=False)
    print('Импорт контактов успешно завершен '
        f'импортировано {count} контактов')

export_notepad_in_csv()

