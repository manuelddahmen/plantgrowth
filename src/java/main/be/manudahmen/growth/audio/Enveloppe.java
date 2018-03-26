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

package be.manudahmen.growth.audio;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.nurbs.CourbeParametriquePolynomialeBezier;

public class Enveloppe {
    private final double minDurationMs;
    private CourbeParametriquePolynomialeBezier form;
    private boolean release = false;
    private boolean end = false;
    Point3D[] points;
    private double time;

    public Enveloppe(double minDurationMs) {
        this.minDurationMs = minDurationMs;

        form = new
                CourbeParametriquePolynomialeBezier(
                points = new Point3D[]{
                        new Point3D(0.0, 0.0, 0.0),
                        new Point3D(0.0, 0.0, 0.0),
                        new Point3D(0.0, 1.0, minDurationMs / 10),
                        new Point3D(0.0, 1.0, minDurationMs / 2),
                        new Point3D(0.0, 1.0, minDurationMs * 3 / 4.0),
                        new Point3D(0.0, 0.2, minDurationMs * 7 / 10.0),
                        new Point3D(0.0, 0.0, minDurationMs)
                });

    }

    public double getVolume(double durationMs) {
        if (!isRelease() && durationMs < minDurationMs / 2) {
            return form.calculerPoint3D(durationMs).getY();
        } else if (!isRelease() && durationMs > minDurationMs) {
            time = durationMs;
            return 1.0;
        } else if (isRelease()) {
            double facteurAmpl = form.calculerPoint3D(durationMs - time).getY();
            if (facteurAmpl <= 0.0)
                fireEndEvent();
        }
        return 0.0;
    }

    public void setRelease() {
        this.release = true;
        time = 0.5;
    }

    public void fireEndEvent() {
        this.end = true;
    }

    public boolean isRelease() {
        return release;
    }

    public boolean isEnd() {
        return end;
    }
}
