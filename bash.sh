cd sources/aggregator
mvn --fail-at-end -Prun-its verify
mvn --fail-at-end -Preporting site
repo init -u https://github.com/auraecosystem/maven-csr.git
repo sync
repo start main --all

mkdir maven
cd maven
repo init -u https://github.com/auraecosystem/maven-csr.git
repo sync
repo start doxia-509 --all
