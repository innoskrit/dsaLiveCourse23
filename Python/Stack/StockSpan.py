class StockSpan:

    def stockSpan(arr, n):
        stack = []
        ans = []
        span = []

        for i in range(n):
            while stack and arr[i] >= arr[stack[-1]]:
                stack.pop()
            if len(stack) == 0:
                ans.append(-1)
            else:
                ans.append(stack[-1])
            stack.append(i)

        for i in range(n):
            span.append(i - ans[i])
        return span

if __name__ == '__main__':
    arr = [100, 80, 60, 70, 60, 75, 85]
    ans = StockSpan.stockSpan(arr, len(arr))
    print(ans)