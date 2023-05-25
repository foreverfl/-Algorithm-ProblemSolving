N = input()
mail_set = set()
for i in range(int(N)):
    str = input()
    tmp_list = str.split("@")
    tmp_list[0] = tmp_list[0].replace(".", "")
    if "+" in tmp_list[0]:
        plus_index = tmp_list[0].find("+")
        tmp_list[0] = tmp_list[0][:plus_index]
    mail = '@'.join(tmp_list)
    mail_set.add(mail)

print(len(mail_set))
