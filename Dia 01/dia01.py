with open("Dia 01/dia01.txt") as f:
    data = [i for i in f.read().strip().split("\n")]

# Pt 1
sum = 0
max = 0
for i in data:
    if i == "":
        sum = 0
    else:
        sum += int(i)
        if sum > max:
            max = sum

print(max)

# Pt 2
sum = 0
list = []
total_sum = 0
for i in data:
    if i == "":
        list.append(sum)
        sum = 0
    else:
        sum += int(i)

list.sort(reverse=True)

for i in range(0, 3):
    total_sum += list[i]

print(total_sum)
