#java ail.mas.AIL src/examples/gwendolen/failuredetection/syntheticexamples/_0/0.ail >> results.csv
#!/bin/bash

# Create a file called log.csv to store the output
touch results.csv
max=12
# Loop 50 times

for i in 01 02 03 10 12 13 20 21 23 30 31 32;
do
  # Run the Java file and save the output to a variable
  output=$(./fast-downward.py --alias seq-sat-lama-2011 ../benchmarks/gwendolen/domain.pddl ../benchmarks/gwendolen/problem$i.pddl)

  # Print the iteration number and the output to the log.csv file
  echo "$i) ------------------------------------------------" >> results.csv
  echo "$output" >> results.csv
  echo "" >> results.csv
done
