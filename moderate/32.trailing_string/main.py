import sys
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.strip()
    if test:
        text, suffix = test.split(",")
        print int(text.endswith(suffix))
test_cases.close()
