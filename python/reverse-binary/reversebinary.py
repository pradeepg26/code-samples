#!/usr/bin/python
import math

def num_bits(x):
  return int(math.ceil(math.log(x + 1, 2)))

def to_reverse_binary(num):
  n = num_bits(num)
  r = num
  c = 1
  output = 0
  while r:
    bit = r % 2
    output += bit * (2 ** (n - c))
    r = r / 2
    c += 1
  return output

def main():
  num = int(raw_input())
  print to_reverse_binary(num)

if __name__ == '__main__':
  main()
