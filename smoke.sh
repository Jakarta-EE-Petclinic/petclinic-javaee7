#!/usr/bin/env bash


function smokeTestProfiles() {
	echo "smokeTestProfiles"
	TEST_CATEGORY=$1
	PROFILES=$2
	for i in $PROFILES
	do
		echo "===================================="
		LOGFILE="log/smoke-$TEST_CATEGORY-$i.log"
		echo "------------------------------------"
		echo $TEST_CATEGORY
		echo $i
		echo "------------------------------------"
		echo $LOGFILE
		./mvnw -e -P$i -DskipTests=true clean install dependency:sources dependency:resolve dependency:resolve-plugins > $LOGFILE
		echo "------------------------------------"
		cat $LOGFILE | grep -v "INFO"
		echo "------------------------------------"
		cat $LOGFILE | grep "BUILD SUCCESS"
	 	echo "------------------------------------"
	 	echo $LOGFILE
	 	echo "------------------------------------"
	done
}

function smokeTestAll() {
	smokeTestProfiles "ALL" "default wildfly-managed wildfly-remote glassfish-managed glassfish-remote"
}

function smokeTestRegression() {
	smokeTestProfiles "Regression" "default"
}

function smokeTestWorkInProgress() {
	smokeTestProfiles "WorkInProgress" "default wildfly-managed glassfish-managed"
}

function smokeTestsAdHoc() {
	echo "smokeTestsAdHoc"
	#./mvnw -Psetup
	#./mvnw -Pqa
	#./mvnw clean install | grep -v "INFO"
	#./mvnw -Pwlp-run clean install | grep -v "INFO"
	#./mvnw -Pwf-run clean install | grep -v "INFO"
}

function smoke() {
	#smokeTestRegression
	smokeTestWorkInProgress
}

function run() {
  ./mvnw
}

function main() {
		#smokeTestAll
		smoke
		#run
		#smokeTestsAdHoc
}

main
