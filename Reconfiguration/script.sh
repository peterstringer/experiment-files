#java ail.mas.AIL src/examples/gwendolen/failuredetection/syntheticexamples/_0/0.ail >> results.csv
#!/bin/bash

# Create a file called log.csv to store the output
touch results.csv
max=12
# Loop 50 times

for i in 01 03 04 10 13 14 15 12 21 24 25 30 31 34 37 36 40 41 42 43 45 46 47 48 51 52 54 57 58 63 64 67 73 74 75 76 78 84 85 87;
do
  # Run the Java file and save the output to a variable
  output=$(./fast-downward.py --alias seq-sat-lama-2011 ../benchmarks/gwendolen/domain.pddl ../benchmarks/gwendolen/$i.pddl)

  # Print the iteration number and the output to the log.csv file
  echo "$i) ------------------------------------------------" >> results.csv
  echo "$output" >> results.csv
  echo "" >> results.csv
done
