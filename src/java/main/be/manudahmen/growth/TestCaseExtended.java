/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

package be.manudahmen.growth;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Properties;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.ZBuffer;
import junit.framework.TestCase;
import org.junit.Test;

import javax.imageio.ImageIO;

public class TestCaseExtended extends TestCase {
    private boolean isInitialized = false;
    private int serId;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        if (!isInitialized) {
            loadSaveNewSerId();
            emptyTestResultsDirectory();
            isInitialized = true;
        }
    }

    protected void assertEqualsNaNPoint3D(Point3D x) {
        assertEquals(x.get(0) + x.get(1) + x.get(2), Double.NaN);
    }

    public int loadSaveNewSerId() {
        File file = new File("configTest.properties");
        if (!file.exists()) {
        }
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));

            String property = properties.getProperty(getClass().getCanonicalName());
            if (property != null) {
                setSerId(Integer.parseInt(property) + 1);
            } else {
                createNewId(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.put(getClass().getCanonicalName(), ((Integer) getSerId()).toString());
        try {
            properties.store(new FileOutputStream(file), "Saved again");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return getSerId();
    }

    private void createNewId(Class myClass) {
        int nextInt = (int) (Math.random() * 10000000);
        setSerId(nextInt);
    }

    public void setSerId(int serId) {
        this.serId = serId;
    }

    public int getSerId() {
        return serId;
    }

    public File getUniqueFilenameForProduction(String directory, String baseFilename, String extension) throws IOException {
        File file;
        int lastId = loadSaveNewSerId();
        do {
            file = new File(
                    (directory == null ? "" : directory + File.separator) +
                            baseFilename + "-" + (lastId + 1) +
                            (extension == null ? "" : "_." + extension));
            System.out.println(file.getCanonicalPath().toString());
            setSerId(++lastId);
            loadSaveNewSerId();
        }
        while (file.exists());

        return file;
    }

    public void assertEqualsPoint3D(Point3D x, Point3D y, double delta) {
        for (int i = 0; i < 3; i++) {
            assertEquals(y.get(i), x.get(i), delta);
        }
    }

    public void writeImage(BufferedImage image) {
        try {
            java.io.File imageFile = getUniqueFilenameForProduction("testResults", getClass().getCanonicalName() + "___" + getClass().getEnclosingMethod(), "jpg");
            ImageIO.write(image, "jpg", imageFile);
            System.out.println(imageFile + " written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeImage(ZBuffer z) {
        z.draw();
        writeImage(z.image());

    }

    @Test
    public void testVoid() {
        assertTrue(true);
    }

    public static void emptyTestResultsDirectory() {
        for (String f : new File("testResults").list()) {
            new File("testResults" + File.separator + f).delete();
        }
    }
}
