n = int(input())
narr = sorted(list(map(int,input().split())))

m = int(input())
marr = list(map(int, input().split()))


for i in range(m):
    left = 0
    right = len(narr) -1
    target = marr[i]

    while(left <= right):
        mid = (left + right) //2
        if target == narr[mid]:
            print(1)
            break

        elif target < narr[mid]:
            right = mid -1

        else:
            left = mid + 1

    else:
        print(0)