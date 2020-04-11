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
 *     Foobar is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Foobar is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

package be.manudahmen.growth.graphics;

import one.empty3.library.Point3D;

import javax.vecmath.Matrix4d;
import javax.vecmath.Vector3d;

public class Rotation {
    private Matrix4d matriceRotation;
    private Point3D origin;

    public Rotation(Point3D vecteur, Point3D origin, double angle) {
        this.origin = origin;
        double[] pointAngle = new double[]{0, 0, 0, 0};
        Point3D v2 = vecteur.moins(origin);
        rq(pointAngle, angle, v2.getX(), v2.getY(), v2.getZ());
        double[] mat44 = new double[16];
        qm(mat44, pointAngle);

        matriceRotation = new Matrix4d(mat44);


    }


    public static Point3D rotate(Point3D originVector, Point3D vector, double angle, Point3D pointToRotate) {
        Rotation rot = new Rotation(vector, originVector, angle);
        Point3D rotated = rot.rotate(pointToRotate);
        System.out.println("Axe              : " + originVector + " -> " + vector);
        System.out.println("Point de départ  : " + pointToRotate);
        System.out.println("Point transformé : " + rotated);
        return rotated;
    }

    public Point3D rotate(Point3D p) {
        p = p.moins(origin);
        Vector3d p2 = new Vector3d(p.getX(), p.getY(), p.getZ());
        matriceRotation.transform(p2);
        return new Point3D(p2.x, p2.y, p2.z).plus(origin);
    }

    private void rq(double[] _q, double a, double x, double y, double z) {
        double sin_a = Math.sin(a / 2);
        double cos_a = Math.cos(a / 2);

        _q[0] = x * sin_a;
        _q[1] = y * sin_a;
        _q[2] = z * sin_a;
        _q[3] = cos_a;

        nq(_q);
    }


    private void nq(double[] q_) {
        double l = Math.sqrt(q_[3] * q_[3] + q_[0] * q_[0] + q_[1] * q_[1] + q_[2] * q_[2]);
        l = 1 / l;
        q_[3] = q_[3] * l;
        q_[0] = q_[0] * l;
        q_[1] = q_[1] * l;
        q_[2] = q_[2] * l;
    }

    private void qm(double[] mat, double[] q) {
        double xx = q[0] * q[0];
        double xy = q[0] * q[1];
        double xz = q[0] * q[2];
        double xw = q[0] * q[3];

        double yy = q[1] * q[1];
        double yz = q[1] * q[2];
        double yw = q[1] * q[3];

        double zz = q[2] * q[2];
        double zw = q[2] * q[3];

        mat[0] = 1 - 2 * (yy + zz);
        mat[1] = 2 * (xy - zw);
        mat[2] = 2 * (xz + yw);

        mat[4] = 2 * (xy + zw);
        mat[5] = 1 - 2 * (xx + zz);
        mat[6] = 2 * (yz - xw);

        mat[8] = 2 * (xz - yw);
        mat[9] = 2 * (yz + xw);
        mat[10] = 1 - 2 * (xx + yy);

        mat[3] = mat[7] = mat[11] = mat[12] = mat[13] = mat[14] = 0;
        mat[15] = 1;
    }

}
