def solution(arr1, arr2):
    answer = [[0] * len(arr2[0]) for _ in range(len(arr1))]
    total = 0
    for a in range(len(arr1)):
        for c in range(len(arr2[0])):
            for b in range(len(arr2)):
                # print(a,b,b,c)
                total += arr1[a][b] * arr2[b][c]
            # print('---------------')
            answer[a][c] = total
            total = 0
    return answer