cd sources/aggregator
mvn --fail-at-end -Prun-its verify
mvn --fail-at-end -Preporting site
repo init -u https://github.com/auraecosystem/maven-csr.git
repo sync
repo start doxia-569 --all
mkdir mavenmkdir maven
cd maven
repo init -u https://gitbox.apache.org/repos/asf/maven-sources.git
repo sync
repo start doxia-569 --all
cd maven
repo init -u https://github.com/auraecosystem/maven-csr.git
repo sync
repo start doxia-569 --all
gcc main.c ascii.c -o ascii_art
./ascii_art
