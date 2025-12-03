# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/lc-wang/test-framework.git;protocol=https;branch=master"

# Modify these as desired
PV = "main+git"
SRCREV = "d0cbcc7c340c3fcab48a76480c35b90a3c8a7ac2"

S = "${WORKDIR}/git"

# NOTE: no Makefile found, unable to determine what needs to be done

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	:
}

do_install () {
    install -d ${D}/opt/test-framework

    cp -r ${S}/core   ${D}/opt/test-framework/
    cp -r ${S}/configs   ${D}/opt/test-framework/
    cp -r ${S}/scripts   ${D}/opt/test-framework/
    cp -r ${S}/tests     ${D}/opt/test-framework/
    cp -r ${S}/test_assets ${D}/opt/test-framework/ || true

    install -d ${D}${bindir}

    cat << 'EOF' > ${D}${bindir}/testfw
#!/bin/sh
cd /opt/test-framework
exec ./core/runner_menu.sh "$@"
EOF

    chmod 0755 ${D}${bindir}/testfw
}

FILES:${PN} += "/opt/test-framework"
FILES:${PN} += "${bindir}/testfw"
