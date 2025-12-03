DESCRIPTION = "Image with test-framework in kiosk mode"
LICENSE = "MIT"

require recipes-graphics/images/core-image-weston.bb

inherit testfw-image

IMAGE_INSTALL:append = " test-framework"
