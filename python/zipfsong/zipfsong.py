#!/usr/bin/python

def main():
    l = raw_input()
    (n, m) = map(int, l.split())
    pq = []
    i = 0
    while i < n:
        l = raw_input()
        (f, s) = l.split(' ')
        q = int(f) * (i + 1)
        pq.append((q, n - i, s))
        i += 1
    topn = sorted(pq, reverse=True)[:m]
    for (q, i, s) in topn:
        print s

if __name__ == "__main__":
    main()
